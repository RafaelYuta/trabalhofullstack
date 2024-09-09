document.getElementById('form').addEventListener('submit', async (event) => {
    event.preventDefault();
    const name = document.getElementById('name').value;
    const cpf = document.getElementById('cpf').value;
    const numero = document.getElementById('numero').value;

    const pessoa = {cpf, name, numero}

    try {
        const response = await fetch('http://localhost:8080/user/adicionar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(pessoa)
        });
        const result = await response.json();
        if (response.ok) {
            console.log("AAAAAAAA");
            alert('AAAAAAAA');
        } else {
        }
    } catch (error) {
        console.log(error);
        alert('Deu errado :(');
    }

})