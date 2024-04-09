import request from '@/utils/request'

// 查询报名信息管理列表
export function listRegistrations(query) {
  return request({
    url: '/ActivitySys/registrations/list',
    method: 'get',
    params: query
  })
}

// 查询报名信息管理详细
export function getRegistrations(RegId) {
  return request({
    url: '/ActivitySys/registrations/' + RegId,
    method: 'get'
  })
}

// 新增报名信息管理
export function addRegistrations(data) {
  return request({
    url: '/ActivitySys/registrations',
    method: 'post',
    data: data
  })
}

// 修改报名信息管理
export function updateRegistrations(data) {
  return request({
    url: '/ActivitySys/registrations',
    method: 'put',
    data: data
  })
}

// 删除报名信息管理
export function delRegistrations(RegId) {
  return request({
    url: '/ActivitySys/registrations/' + RegId,
    method: 'delete'
  })
}
