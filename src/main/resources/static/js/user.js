// table()
//
//
// function table() {
//     $('#userTable').append(
//         '<tr><td>' + "1" +
//         '</td><td>' + "2" +
//         '</td><td>' + "3" +
//         '</td><td>' + "8" +
//         '</td><td>' + "7" +
//         '</td><td>' + "6" +
//         '</td><td>' + "4" +
//         '</td><td>' + "5" +
//         '</td><tr>');
//
// }

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
fetch(url)
    .then(res => res.json())
    .then(data => renderRow(data))