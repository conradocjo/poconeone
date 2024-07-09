# mapeamento @OneToOne JPA:

A Ideia desta POC é demonstrar por meio de um exemplo prático o comportamento do mapeamento @OneToOne e desta forma ser um material de consulta.

Para o exemplo em questão uma pessoa pode ter apenas uma função em uma empresa.

Abaixo o mapeamento da tabela relacionado a cargo:

![image](https://github.com/conradocjo/poconeone/assets/29169349/2678724d-5911-4eb8-aafb-fe7d691f2f36)

Abaixo o mapeamento da tabela Pessoa:

![image](https://github.com/conradocjo/poconeone/assets/29169349/37893919-9e2d-4eda-af45-dcc42999e5e5)


O Código gerado apartir do JPA, reproduzido por meio de um diagrama de banco de dados:

![image](https://github.com/conradocjo/poconeone/assets/29169349/c898950e-1c7a-4ee3-839c-49a0a4c5c643)


Neste esquema não é possível usar a mesma chave para outra pessoa.





