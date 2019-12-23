import axios from 'axios'
import env from '../../environment'
import Session from '../session'
import ErrorCode from '../../constants/errorCode'

axios.defaults.baseURL = env.backendDomain
axios.defaults.headers.common['Content-Type'] = 'application/json;charset=UTF-8'

// 添加请求拦截器
axios.interceptors.request.use((config = {}) => {

  if (Session.checkTokenIsExist()) {
    config.headers['jwt-token'] = Session.getToken()
  }

  return config
})

// 添加响应拦截器
axios.interceptors.response.use((response) => {
  return response.data
 }, (error) => {
  console.log('401: redirect to admin-login error :', error)
  if (error.request.status === ErrorCode.UN_AUTH) {
    Session.removeToken()
    window.location.href = "/admin-login"
  }

  return Promise.reject(error)
})

export default class HTTP {

  static $axios = axios
}