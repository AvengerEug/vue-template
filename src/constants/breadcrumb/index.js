const userList = {
  displayName: 'router.user-list',
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

module.exports = {
  'user-list': [ userList ],
  'user-edit': [ userList, userEdit ],
  'user-create': [userList, userCreate],
  'example-table': [ exampleTable ]
}
