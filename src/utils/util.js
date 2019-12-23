export default class Util {

  static fetchRouteQuery = route => {
    return route.query
  }

  static buildRedirectUrl = (route, token) => {
    let query = Util.fetchRouteQuery(route)

    if (token) {
      query['token'] = token
    }

    let url = query.url + '?'
    const queryKeys = Object.keys(query)
    let queryUrl = ''

    for (let i = 0; i < queryKeys.length; i++) {
      let item = queryKeys[i]
      if (item === 'url') {
        continue
      }

      queryUrl += (queryUrl ? '&' : '') + item + '=' + query[item]
    }

    return url + queryUrl
  }
}