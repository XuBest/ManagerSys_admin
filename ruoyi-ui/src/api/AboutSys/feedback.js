import request from '@/utils/request'

// 查询用户反馈管理列表
export function listFeedback(query) {
  return request({
    url: '/AboutSys/feedback/list',
    method: 'get',
    params: query
  })
}

// 查询用户反馈管理详细
export function getFeedback(fbId) {
  return request({
    url: '/AboutSys/feedback/' + fbId,
    method: 'get'
  })
}

// 新增用户反馈管理
export function addFeedback(data) {
  return request({
    url: '/AboutSys/feedback',
    method: 'post',
    data: data
  })
}

// 修改用户反馈管理
export function updateFeedback(data) {
  return request({
    url: '/AboutSys/feedback',
    method: 'put',
    data: data
  })
}

// 删除用户反馈管理
export function delFeedback(fbId) {
  return request({
    url: '/AboutSys/feedback/' + fbId,
    method: 'delete'
  })
}
