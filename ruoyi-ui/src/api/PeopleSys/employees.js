import request from '@/utils/request'

// 查询职工信息管理列表
export function listEmployees(query) {
  return request({
    url: '/PeopleSys/employees/list',
    method: 'get',
    params: query
  })
}

// 查询职工信息管理详细
export function getEmployees(EmployeeId) {
  return request({
    url: '/PeopleSys/employees/' + EmployeeId,
    method: 'get'
  })
}

// 新增职工信息管理
export function addEmployees(data) {
  return request({
    url: '/PeopleSys/employees',
    method: 'post',
    data: data
  })
}

// 修改职工信息管理
export function updateEmployees(data) {
  return request({
    url: '/PeopleSys/employees',
    method: 'put',
    data: data
  })
}

// 删除职工信息管理
export function delEmployees(EmployeeId) {
  return request({
    url: '/PeopleSys/employees/' + EmployeeId,
    method: 'delete'
  })
}
