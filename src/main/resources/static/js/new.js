// async
function test() {

    var roleSet = new Set();
    roleSet.add({id:2, role:'USER'})

    let user = {
        firstname: 'John',
        lastname: 'Smith',
        age: 33,
        email: '11111@m.ru',
        password: 'tttrrr',
        roles: roleSet,
        isuser: Boolean(true),
        isadmin: Boolean(false)
    };

// let response = await fetch('http://localhost:8080/api/new', {
//     method: 'POST',
//     headers: {
//         'Content-Type': 'application/json;charset=utf-8'
//     },
//     body: JSON.stringify(user)
// });
//
// let result = await response.json();
// alert(result.message);

    $.ajax({
        url: "/api/new",
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(user)
    }).done((msgSave) => {
        document.location.href = '/admin/all'

    })
}

test()