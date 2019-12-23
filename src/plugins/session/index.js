export default class Session {

  static tokenKey = 'jwt-token'

  static getItem = key => {
    const item = window.localStorage.getItem(key)
    return item
  }

  static setItem = (key, value) => {
    return window.localStorage.setItem(key, value)
  }

  static removeItem = key => {
    return window.localStorage.removeItem(key)
  }

  static checkIsExist = key => {
    return Session.getItem(key) ? true : false
  }

  static checkTokenIsExist = _ => {
    return Session.checkIsExist(Session.tokenKey)
  }

  static getToken = _ => {
    return Session.getItem(Session.tokenKey)
  }

  static setToken = value => {
    Session.setItem(Session.tokenKey, value)
  }

  static removeToken = _ => {
    Session.removeItem(Session.tokenKey)
  }

}