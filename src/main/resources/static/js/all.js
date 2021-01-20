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
            '</td><td>' + "4" +
            '</td><td>' + "5" +
            '</td><tr>'
    })
    tableContent.innerHTML = output
}
// Method Get
const urlAll = 'http://localhost:8080/api/all'
fetch(urlAll)
    .then(res => res.json())
    .then(data => renderRow(data))

