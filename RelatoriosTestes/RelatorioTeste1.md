# Relatório 1:
 ## Funcionamento do código:
   Observando o funcionamento do saldo do usuário, é perceptível que quando o valor do estacionamento é maior que o valor do saldo do usuário, quando usamos o método processarPagamento o saldo ficou -10, portanto, é necessário criar um condicional para que se o valor do saldo  for menor do que o valor pago, o usuário deve inserir mais saldo.
 ## Observações:
   Sob outra perspectiva, é interessante a otimização do código, diminuindo uma etapa do processo de pagamento para que o usuário não precise colocar um saldo na conta, e apenas tendo um método para que seja possível pagar o valor, para isso podemos criar uma função tempodeestadia e calcular o valor do tempo de estadia, e após isso criar um método Pagamento
