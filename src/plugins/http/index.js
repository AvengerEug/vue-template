import axios from 'axios'
import env from '../../environment'

axios.defaults.baseURL = env.backendDomain
axios.defaults.headers.common['Content-Type'] = 'application/json;charset=UTF-8'

// 添加请求拦截器
axios.interceptors.request.use((config = {}) => {

  console.log('请求拦截器: ')
  console.log('config :', config)

  config.headers = { 'jwt-token': 'eyJhbGciOiJIUzUxMiJ9.eyJldWdlbmUiOnsidXNlcklkIjoxLCJ1c2VyTmFtZSI6ImV1Z2VuZSIsInBhc3N3b3JkIjoiYWJjMTIzXyJ9LCJleHAiOjE1Njk0NzUxMjF9.Qs84u14hAe_otPl9oF6sTeLyJDFG_E5BzYi8hmNb6_3R-4gZlkHaoF2Z6NN3h7gk1U4uFayPSZP8mu8epfewTA' }

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