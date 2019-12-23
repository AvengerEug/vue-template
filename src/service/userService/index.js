import { HTTP } from '@/plugins'
import API_PATH from '@/constants/apiPath'

export default class UserService {

  static login = async (params) => {
    return await HTTP.$axios.post(API_PATH.USER.LOGIN, params)
  }

  static update = async (params, token) => {
    return await HTTP.$axios.put(API_PATH.USER.UPDATE, params, {
      params: {
        'jwtToken': token
      }
    })
  }

  static getById = async id => {
    return await HTTP.$axios.get(API_PATH.USER.GET_BY_ID.replace(/{id}/, id))
  }

  static fetchUserInfo = async params => {
    return await HTTP.$axios.get(API_PATH.USER.FETCH_USER_INFO, params)
  }

  static parseToken = async token => {
    return await HTTP.$axios.get(API_PATH.USER.PARSE_TOKEN, token)
  }

}