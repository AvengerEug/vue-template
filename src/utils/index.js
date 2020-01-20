import Breadcrumb from '@/constants/breadcrumb'

export default class Utils {

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

  static isExternal = (path) => {
    return /^(https?:|mailto:|tel:)/.test(path)
  }

  static parseBreadcrumb = (currentRoute) => {
    const breadcrumbKeys = Object.keys(Breadcrumb)
    for (let i = 0; i < breadcrumbKeys.length; i++) {
      if (breadcrumbKeys[i] === currentRoute.name) {
        console.log('Breadcrumb[breadcrumbKeys[i]] :', Breadcrumb[breadcrumbKeys[i]])
        return Breadcrumb[breadcrumbKeys[i]]
      }
    }
  }

  static doProcecommonrBreadcrumb = (currentRoute) => {
    return Utils.parseBreadcrumb(currentRoute)
  }
}