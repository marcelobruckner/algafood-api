insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into forma_pagamento(id, descricao) values (1, "Dinheiro");
insert into forma_pagamento(id, descricao) values (2, "Crédito");
insert into forma_pagamento(id, descricao) values (3, "Débito");

insert into estado (id, nome) values (1, "SP");
insert into estado (id, nome) values (2, "RJ");

insert into cidade (id, nome, estado_id) values (1, "Barueri", 1);
insert into cidade (id, nome, estado_id) values (2, "São Paulo", 1);
insert into cidade (id, nome, estado_id) values (3, "Rio de Janeiro", 2);

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,1);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,2);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,3);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (2,1);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (3,1);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (3,2);