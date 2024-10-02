document.addEventListener("DOMContentLoaded", function () {

    const vendaForm = document.getElementById("vendaForm");
    const dataInput = document.getElementById("dataVenda");
    const quantidadeInput = document.getElementById("quantidade");
    const clienteSelect = document.getElementById("clienteVenda");
    const produtoSelect = document.getElementById("produtoVenda");
    const valorInput = document.getElementById("valorVenda");
    const filtroInput = document.getElementById("filtroVenda");
    const vendasTable = document.getElementById("vendasTable").getElementsByTagName('tbody')[0];

    function validarData(data) {
        const regex = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/\d{4}$/;
        return regex.test(data);
    }

    quantidadeInput.maxLength = 255;
    valorInput.maxLength = 13;

    vendaForm.addEventListener("submit", function (event) {
        event.preventDefault();

        if (!validarData(dataInput.value)) {
            alert("Por favor, insira uma data válida no formato DD/MM/AAAA.");
            return;
        }

        if (quantidadeInput.value === "" || produtoSelect.value === "" || valorInput.value === "") {
            alert("Por favor, preencha todos os campos obrigatórios.");
            return;
        }

        const novaVenda = {
            data: dataInput.value,
            quantidade: quantidadeInput.value,
            cliente: clienteSelect.value || "Sem cadastro",
            produto: produtoSelect.value,
            valor: valorInput.value
        };

        const novaLinha = vendasTable.insertRow();
        novaLinha.insertCell(0).textContent = novaVenda.data;
        novaLinha.insertCell(1).textContent = novaVenda.quantidade;
        novaLinha.insertCell(2).textContent = novaVenda.cliente;
        novaLinha.insertCell(3).textContent = novaVenda.produto;
        novaLinha.insertCell(4).textContent = novaVenda.valor;

        vendaForm.reset();
    });

    filtroInput.addEventListener("input", function () {
        const filtro = filtroInput.value.toLowerCase();
        const linhas = vendasTable.getElementsByTagName("tr");

        for (let i = 0; i < linhas.length; i++) {
            const clienteNome = linhas[i].getElementsByTagName("td")[2];
            if (clienteNome) {
                const textoNome = clienteNome.textContent || clienteNome.innerText;
                linhas[i].style.display = textoNome.toLowerCase().indexOf(filtro) > -1 ? "" : "none";
            }
        }
    });
});
