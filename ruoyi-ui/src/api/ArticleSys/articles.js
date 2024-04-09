import request from '@/utils/request'

// 查询公告宣传管理列表
export function listArticles(query) {
  return request({
    url: '/ArticleSys/articles/list',
    method: 'get',
    params: query
  })
}

// 查询公告宣传管理详细
export function getArticles(articleId) {
  return request({
    url: '/ArticleSys/articles/' + articleId,
    method: 'get'
  })
}

// 新增公告宣传管理
export function addArticles(data) {
  return request({
    url: '/ArticleSys/articles',
    method: 'post',
    data: data
  })
}

// 修改公告宣传管理
export function updateArticles(data) {
  return request({
    url: '/ArticleSys/articles',
    method: 'put',
    data: data
  })
}

// 删除公告宣传管理
export function delArticles(articleId) {
  return request({
    url: '/ArticleSys/articles/' + articleId,
    method: 'delete'
  })
}
