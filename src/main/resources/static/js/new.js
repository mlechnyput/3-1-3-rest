var button=document.getElementById('butt_New')
button.addEventListener('click', function (e){
    e.preventDefault()
    sendPost()
    document.location.href = 'http://localhost:8080/admin/all'
})

async function sendPost() {
    const urlNew = "http://localhost:8080/api/new"

    var admCh = Boolean(false)
    var userCh = Boolean(false)

    if ($('#Adm_New').prop("checked")) {
        admCh = true
    }
    if ($('#Us_New').prop("checked")) {
        userCh = true
    }
    const userNew = {
        firstname: $('#First_name_New').val(),
        lastname: $('#Last_name_New').val(),
        age: $('#Age_New').val(),
        email: $('#Email_New').val(),
        password: $('#Password_New').val(),
        isuser: userCh,
        isadmin: admCh
    }

    const headers = {
        'Content-Type': 'application/json'
    }

    try {
        const response = await fetch(urlNew, {
            method: 'POST',
            body: JSON.stringify(userNew),
            headers: headers
        })
        const json=await response.json()
        console.log('Успех: ', JSON.stringify(json))
    }catch (error){
        console.error('Ошибка: ',error)
    }
}

