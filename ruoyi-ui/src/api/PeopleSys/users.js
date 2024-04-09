import request from '@/utils/request'

// 查询用户信息管理列表
export function listUsers(query) {
  return request({
    url: '/PeopleSys/users/list',
    method: 'get',
    params: query
  })
}

// 查询用户信息管理详细
export function getUsers(uid) {
  return request({
    url: '/PeopleSys/users/' + uid,
    method: 'get'
  })
}

// 新增用户信息管理
export function addUsers(data) {
  return request({
    url: '/PeopleSys/users',
    method: 'post',
    data: data
  })
}

// 修改用户信息管理
export function updateUsers(data) {
  return request({
    url: '/PeopleSys/users',
    method: 'put',
    data: data
  })
}

// 删除用户信息管理
export function delUsers(uid) {
  return request({
    url: '/PeopleSys/users/' + uid,
    method: 'delete'
  })
}
