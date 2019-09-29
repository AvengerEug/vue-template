import axios from 'axios'
import env from '../../environment'

axios.defaults.baseURL = env.backendDomain
axios.defaults.headers.common['Content-Type'] = 'application/json;charset=UTF-8'

// 添加请求拦截器
axios.interceptors.request.use((config = {}) => {

  console.log('请求拦截器: ')
  console.log('config :', config)

  return config
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

  static $axios = axios
}