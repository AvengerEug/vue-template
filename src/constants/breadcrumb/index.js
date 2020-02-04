/**
 * displayName: 对应使用国际化文件中router节点中的值, 面包屑显示名称使用
 * routeName: 路由的名称, 面包屑跳转路由使用
 * 
 * 
 * // key为路由的名字，value为数组. 表示当前页面的面包屑配置
 * module.exports = {
 *    key: value
 * }
 */


const userList = {
  // 面包屑和侧边栏菜单显示的名字
  displayName: 'router.user-list',
  // 路由的名字
  routeName: 'user-list'
}

const userEdit = {
  displayName: 'router.user-edit',
  routeName: 'user-edit'
}

const userCreate = {
  displayName: 'router.user-create',
  routeName: 'user-create'
}

const exampleTable = {
  displayName: 'router.example-table',
  routerName: 'example-table'
}

const icons = {
  displayName: 'router.icons',
  routeName: 'icons-index'
}

const socketIndex = {
  displayName: 'router.socket-index',
  routeName: 'socket-index'
}


module.exports = {
  'user-list': [ userList ],
  'user-edit': [ userList, userEdit ],
  'user-create': [userList, userCreate],
  'example-table': [ exampleTable ],
  'icons-index': [ icons ],
  'socket-index': [ socketIndex ]
}
