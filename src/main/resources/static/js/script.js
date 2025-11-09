/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

document.addEventListener("DOMContentLoaded", () => {
    console.log("Página inicial carregada.");
});

function filtrarTabela() {
    const filtroServico = document.getElementById('filtroServico').value;
    const filtroCliente = document.getElementById('filtroCliente').value;
    const filtroColaborador = document.getElementById('filtroColaborador').value;
    
    const linhas = document.querySelectorAll('#tabelaCorpo tr');
    
    linhas.forEach(linha => {
        const servicoId = linha.querySelector('.servico').getAttribute('data-id');
        const clienteId = linha.querySelector('.cliente').getAttribute('data-id');
        const colaboradorId = linha.querySelector('.colaborador').getAttribute('data-id');
        
        const servicoMatch = !filtroServico || servicoId === filtroServico;
        const clienteMatch = !filtroCliente || clienteId === filtroCliente;
        const colaboradorMatch = !filtroColaborador || colaboradorId === filtroColaborador;
        
        if (servicoMatch && clienteMatch && colaboradorMatch) {
            linha.style.display = '';
        } else {
            linha.style.display = 'none';
        }
    });
}

// Filtrar ao carregar a página (caso haja valores pre-selecionados)
document.addEventListener('DOMContentLoaded', filtrarTabela);