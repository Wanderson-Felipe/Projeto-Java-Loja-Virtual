$(document).ready(function () {

    $('#cpf').mask('000.000.000-00');
    $('#telefone').mask('(00) 00000-0000');

    let clientes = [];
    let products = [];
    let selectedClientIndex = -1;
    let selectedProductIndex = -1;

    function atualizarTabelaClientes() {
        let tabela = $('#clientesTable tbody');
        tabela.empty();
        clientes.forEach((cliente, index) => {
            tabela.append(`
                <tr>
                    <td>${cliente.nome}</td>
                    <td>${cliente.cpf}</td>
                    <td>${cliente.telefone}</td>
                    <td>${cliente.endereco}</td>
                    <td>
                        <button onclick="editarCliente(${index})">Editar</button>
                        <button onclick="excluirCliente(${index})">Excluir</button>
                    </td>
                </tr>
            `);
        });
    }

    function limparCamposClientes() {
        $('#nome').val('');
        $('#cpf').val('');
        $('#telefone').val('');
        $('#endereco').val('');
        selectedClientIndex = -1;
    }

    $('#btnEnviar').on('click', function () {
        const nome = $('#nome').val();
        const cpf = $('#cpf').val();
        const telefone = $('#telefone').val();
        const endereco = $('#endereco').val();

        if (nome && cpf && telefone && endereco) {
            if (selectedClientIndex === -1) {
                clientes.push({nome, cpf, telefone, endereco});
            } else {
                clientes[selectedClientIndex] = {nome, cpf, telefone, endereco};
                selectedClientIndex = -1;
            }
            atualizarTabelaClientes();
            limparCamposClientes();
        } else {
            alert('Por favor, preencha todos os campos.');
        }
    });

    window.excluirCliente = function (index) {
        if (confirm('Tem certeza que deseja excluir este cliente?')) {
            clientes.splice(index, 1);
            atualizarTabelaClientes();
        }
    };

    window.editarCliente = function (index) {
        const cliente = clientes[index];
        $('#nome').val(cliente.nome);
        $('#cpf').val(cliente.cpf);
        $('#telefone').val(cliente.telefone);
        $('#endereco').val(cliente.endereco);
        selectedClientIndex = index;
    };

    $('#btnLimpar').on('click', limparCamposClientes);

    $('#productForm').on('submit', function (event) {
        event.preventDefault();

        const nomeProduto = $('#nomeProduto').val();
        const tamanho = $('#tamanho').val();
        const descricao = $('#descricao').val();
        const quantidade = $('#quantidade').val();
        const valor = $('#valor').val();

        if (nomeProduto && tamanho && quantidade && valor) {
            const newProduct = {nomeProduto, tamanho, descricao, quantidade, valor};

            if (selectedProductIndex === -1) {
                products.push(newProduct);
            } else {
                products[selectedProductIndex] = newProduct;
                selectedProductIndex = -1;
            }

            updateProductTable();
            clearProductForm();
        } else {
            alert('Por favor, preencha os campos obrigatórios.');
        }
    });

    $('#clearForm').on('click', clearProductForm);

    function clearProductForm() {
        $('#productForm')[0].reset();
        selectedProductIndex = -1;
    }

    function updateProductTable() {
        const tableBody = $('#productTable tbody');
        tableBody.empty();

        products.forEach((product, index) => {
            const row = `<tr>
                <td>${product.nomeProduto}</td>
                <td>${product.tamanho}</td>
                <td>${product.descricao || ''}</td>
                <td>${product.quantidade}</td>
                <td>${product.valor}</td>
                <td>
                    <button onclick="editProduct(${index})">Alterar</button>
                    <button onclick="deleteProduct(${index})">Excluir</button>
                </td>
            </tr>`;
            tableBody.append(row);
        });
    }

    window.editProduct = function (index) {
        const product = products[index];
        $('#nomeProduto').val(product.nomeProduto);
        $('#tamanho').val(product.tamanho);
        $('#descricao').val(product.descricao);
        $('#quantidade').val(product.quantidade);
        $('#valor').val(product.valor);
        selectedProductIndex = index;
    };

    window.deleteProduct = function (index) {
        if (confirm('Tem certeza que deseja excluir este produto?')) {
            products.splice(index, 1);
            updateProductTable();
        }
    };
});
