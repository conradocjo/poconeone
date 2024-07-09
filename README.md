# mapeamento @OneToOne JPA:

A Ideia desta POC é demonstrar por meio de um exemplo prático o comportamento do mapeamento @OneToOne e desta forma ser um material de consulta.

Para o exemplo em questão uma mensaegm pode ter um título e este título é unico para a mensagem em questão.

Abaixo o mapeamento de mensagens:

![image](https://github.com/conradocjo/poconeone/assets/29169349/0b64a53d-8890-4661-9f3a-f4658ac1be95)


Abaixo o mapeamento da tabela título:

![image](https://github.com/conradocjo/poconeone/assets/29169349/125782c5-aeec-419e-a2d5-7aa15f6eb17e)



O Código gerado apartir do JPA, reproduzido por meio de um diagrama de banco de dados:

![image](https://github.com/conradocjo/poconeone/assets/29169349/084e4bd1-d304-431f-a33e-76e86fdcc899)

Consulta exemplo:

![image](https://github.com/conradocjo/poconeone/assets/29169349/847de272-17f9-44a0-bc17-7e2cd51fa758)



![image](https://github.com/conradocjo/poconeone/assets/29169349/1564718c-d3d9-49c0-b5ab-aa9b042d3708)


Tentativa de cadastrar outro texto usando o mesmo título cadastrado no banco:

![image](https://github.com/conradocjo/poconeone/assets/29169349/6f762088-936d-468f-9932-c2e9e68355a9)

