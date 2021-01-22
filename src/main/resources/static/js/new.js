const urlNew = "http://localhost:8080/api/new"

var admCh=Boolean(false)
var userCh=Boolean(false)

if ($('#Adm_New').prop("checked")){
    admCh=true
}

const userNew = {
    firstname: 'eew',
    lastname: 're',
    age: 76,
    email: 'ew@m.ru',
    password: '123',
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

