
const tableContent = document.getElementById('userRow')
let output = ''

const renderRow = (user) => {
        let strRole=''
        for (let item of user.roles){
            strRole+=item.role + ' '
        }
        output =
            '<tr><td>' + user.id +
            '</td><td>' + user.firstname +
            '</td><td>' + user.lastname +
            '</td><td>' + user.age+
            '</td><td>' + user.email+
            '</td><td>' + strRole +
            '</td><tr>'

    tableContent.innerHTML = output
}

const url = 'http://localhost:8080/api/user'

//формирует одиночную user-таблицу, как для админа (adminuser.html), так и для юзера (user.html)

fetch(url)
    .then(res => res.json())
    .then(data => renderRow(data))