import axios from 'axios'
import env from '../../environment'

axios.defaults.baseURL = env.backendDomain
axios.defaults

// 添加请求拦截器
axios.interceptors.request.use((config = {}) => {

  console.log('请求拦截器: ' + config)
})

// 添加响应拦截器
axios.interceptors.response.use((response) => {
  console.log('响应内容 :', response)
  return response.data
 }, (error) => {
  console.log('请求失败: ', error)
  return Promise.reject(error)
})

export default class HTTP {

  static get = (url, params) => {
    return new Promise((resolve, reject) => {
      const response = axios.get(url, params)
      if (response.status !== 200) {
        reject("请求失败: " + response.errorMessage)
      } else {
        resolve(response)
      }
    })
  }

  static post = (url, params) => {
    return new Promise((resolve, reject) => {
      const response = axios.post(url, params)
      if (response.status !== 200) {
        reject("请求失败: " + response.errorMessage)
      } else {
        resolve(response)
      }
    })
  }

  static put = (url, params) => {
    return new Promise((resolve, reject) => {
      const response = axios.put(url, params)
      if (response.status !== 200) {
        reject("请求失败: " + response.errorMessage)
      } else {
        resolve(response)
      }
    })
  }

  static delete = (url, params) => {
    return new Promise((resolve, reject) => {
      const response = axios.delete(url, params)
      if (response.status !== 200) {
        reject("请求失败: " + response.errorMessage)
      } else {
        resolve(response)
      }
    })
  }
}