# Aplicação WEB do Sistema de Controle de Passagem usando Java Servlet.

## Contextualização

Sistema de Controle de Passagem realiza a consulta e marcação de voo e assento usando Java Servlet.
O programa controla e mantêm os voos e assentos. 
O programa realiza consultas e marcações se comunicando com o servidor através de formulários html e Servlets.

### Consulta Voo

Para o programa consultar o voo é necessário chamar o formulário html "VerificarStatus.html". 
Na consulta o usuário especifica um voo e assento para saber se estão disponíveis através do Servlet. 

O servlet retorna:
 - 0: voo disponível
 - 1: assento indisponível
 - 2: assento inexistente
 - 3: voo inexistente
 - 4: marcação realizada

Todos os códigos dos voos se iniciam com a letra "A":
 - **"A1"**

### Marcação Voo

A marcação envolve chamar o formulário "MarcarVoo.html" e enviar o código do voo e assento e marcar como indisponível. 

O servlet retorna:
 - 0: voo disponível
 - 1: assento indisponível
 - 2: assento inexistente
 - 3: voo inexistente
 - 4: marcação realizada

## Arquivos

- pom.xml - Arquivo de configuração da ferramenta de automação Maven.