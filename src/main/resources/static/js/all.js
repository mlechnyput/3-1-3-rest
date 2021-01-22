const tableContent = document.getElementById('userRows')

let output = ''

const renderRow = (users) => {
    users.forEach(user => {
        let strRole = ''
        for (let item of user.roles) {
            strRole += item.role + ' '
        }
        output +=
            '<tr><td>' + user.id +
            '</td><td>' + user.firstname +
            '</td><td>' + user.lastname +
            '</td><td>' + user.age +
            '</td><td>' + user.email +
            '</td><td>' + strRole +
            '</td><td>' +
            '<button type="button" name="Green2" class="btn btn-info" data-toggle="modal" data-target="#myEdit" id="'+ user.id +'">Edit</button>' +
            '</td><td>' +
            '<button type="button" name="Red1" class="btn btn-danger" data-toggle="modal" data-target="#myDelete" id="'+ user.id +'">Delete</button>' +
            '</td><tr>'
    })
    tableContent.innerHTML = output
}
// Method Get
const urlAll = 'http://localhost:8080/api/all'
fetch(urlAll)
    .then(res => res.json())
    .then(data => renderRow(data))

