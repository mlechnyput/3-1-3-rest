const urlNew = "http://localhost:8080/api/new"

let roleSet = new Set();
roleSet.add({id: 2, role: 'USER'})

const userNew = {
    firstname: 'John',
    lastname: 'Smith',
    age: 33,
    email: '11111@m.ru',
    password: 'tttrrr',
    roles: roleSet,
    isuser: Boolean(true),
    isadmin: Boolean(false)
}

function sendPost(method, url, body = null) {
    const headers = {
        'Content-Type': 'application/json'
    }
    return fetch(url,{
        method:method,
        body:JSON.stringify(body),
        headers:headers
    }).then(res=>{
        return res.json()
    })
}

sendPost('POST', urlNew, userNew)
    .then(data=>console.log(data))
    .catch(err=>console.log(err))

