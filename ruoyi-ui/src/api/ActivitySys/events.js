import request from '@/utils/request'

// 查询活动发布管理列表
export function listEvents(query) {
  return request({
    url: '/ActivitySys/events/list',
    method: 'get',
    params: query
  })
}

// 查询活动发布管理详细
export function getEvents(EventId) {
  return request({
    url: '/ActivitySys/events/' + EventId,
    method: 'get'
  })
}

// 新增活动发布管理
export function addEvents(data) {
  return request({
    url: '/ActivitySys/events',
    method: 'post',
    data: data
  })
}

// 修改活动发布管理
export function updateEvents(data) {
  return request({
    url: '/ActivitySys/events',
    method: 'put',
    data: data
  })
}

// 删除活动发布管理
export function delEvents(EventId) {
  return request({
    url: '/ActivitySys/events/' + EventId,
    method: 'delete'
  })
}
