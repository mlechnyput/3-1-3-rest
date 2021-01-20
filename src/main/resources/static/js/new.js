async function test() {

let user = {
    firstname: 'John',
    lastname: 'Smith',
    age: 33,
    email: '11111@m.ru',
    password: 'tttrrr',
    isuser: false,
    isadmin: true
};

let response = await fetch('/api/new', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(user)
});

let result = await response.json();
alert(result.message);
}

test()