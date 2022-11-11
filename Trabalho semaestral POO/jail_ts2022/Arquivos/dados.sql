select * from tbcelas;
INSERT INTO `jail_ts2022`.`tbcelas` (`cela`) VALUES ('A');
INSERT INTO `jail_ts2022`.`tbcelas` (`cela`) VALUES ('B');
INSERT INTO `jail_ts2022`.`tbcelas` (`cela`) VALUES ('C');
INSERT INTO `jail_ts2022`.`tbcelas` (`cela`) VALUES ('D');

UPDATE `jail_ts2022`.`tbcelas` SET `capacidadeMax` = '4' WHERE (`id_celas` = '5');
UPDATE `jail_ts2022`.`tbcelas` SET `capacidadeMax` = '4' WHERE (`id_celas` = '6');
UPDATE `jail_ts2022`.`tbcelas` SET `capacidadeMax` = '4' WHERE (`id_celas` = '7');
UPDATE `jail_ts2022`.`tbcelas` SET `capacidadeMax` = '4' WHERE (`id_celas` = '8');

select * from tbcama enum('Masculino','Feminino');
select * from tbcama join tbcelas_has_tbcama on tbcama.id_cama = tbcelas_has_tbcama.id_cama join tbcelas on tbcelas.id_celas = tbcelas_has_tbcama.id_celas order by cela ;

select * from tbcama join tbcelas_has_tbcama on tbcama.id_cama = tbcelas_has_tbcama.id_cama ;
-- ***********************************************************************************************************************************************************
INSERT INTO `jail_ts2022`.`tbnacionalidade` (`nacionalidade`) VALUES ('Angolana');
INSERT INTO `jail_ts2022`.`tbnacionalidade` (`nacionalidade`) VALUES ('Brasileira');
INSERT INTO `jail_ts2022`.`tbnacionalidade` (`nacionalidade`) VALUES ('Cabo Verdiana');
INSERT INTO `jail_ts2022`.`tbnacionalidade` (`nacionalidade`) VALUES ('Mocambicana');
INSERT INTO `jail_ts2022`.`tbnacionalidade` (`nacionalidade`) VALUES ('Sao Tomense');
INSERT INTO `jail_ts2022`.`tbnacionalidade` (`nacionalidade`) VALUES ('Sul Africana');
INSERT INTO `jail_ts2022`.`tbnacionalidade` (`nacionalidade`) VALUES ('Tanzaniana' );

-- solicitar as nacinalidade
 select * from tbnacionalidade order by nacionalidade;
 
INSERT INTO `jail_ts2022`.`tbprovincias` (`Provincia`, `id_nacionalidade`) VALUES ('Cabo Delgado', '4');
INSERT INTO `jail_ts2022`.`tbprovincias` (`Provincia`, `id_nacionalidade`) VALUES ('Niassa', '4');
INSERT INTO `jail_ts2022`.`tbprovincias` (`Provincia`, `id_nacionalidade`) VALUES ('Nampula', '4');
INSERT INTO `jail_ts2022`.`tbprovincias` (`Provincia`, `id_nacionalidade`) VALUES ('Zambezia', '4');
INSERT INTO `jail_ts2022`.`tbprovincias` (`Provincia`, `id_nacionalidade`) VALUES ('Tete', '4');
INSERT INTO `jail_ts2022`.`tbprovincias` (`Provincia`, `id_nacionalidade`) VALUES ('Sofala', '4');
INSERT INTO `jail_ts2022`.`tbprovincias` (`Provincia`, `id_nacionalidade`) VALUES ('Manica', '4');
INSERT INTO `jail_ts2022`.`tbprovincias` (`Provincia`, `id_nacionalidade`) VALUES ('Inhambane', '4');
INSERT INTO `jail_ts2022`.`tbprovincias` (`Provincia`, `id_nacionalidade`) VALUES ('Gaza', '4');
INSERT INTO `jail_ts2022`.`tbprovincias` (`Provincia`, `id_nacionalidade`) VALUES ('Maputo Provincia', '4');
INSERT INTO `jail_ts2022`.`tbprovincias` (`Provincia`, `id_nacionalidade`) VALUES ('Maputo Cidade', '4');
 -- consultar
 alter table tbprovincias drop naturalidade;
 alter table tbprovincias add  `Provincia` VARCHAR(30) after id_Provincias;
 select * from tbprovincias  join  tbnacionalidade on tbprovincias.id_nacionalidade  = tbnacionalidade.id_nacionalidade order by Provincia;
 
 
INSERT INTO `jail_ts2022`.`tbcrimes` (`categoriaDeCrime`, `duracaoEmAno`, `duracaoEmMeses`) VALUES ('Nao definido', '0', '3');
INSERT INTO `jail_ts2022`.`tbcrimes` (`categoriaDeCrime`, `duracaoEmAno`, `duracaoEmMeses`) VALUES ('Burla', '0', '6');
INSERT INTO `jail_ts2022`.`tbcrimes` (`categoriaDeCrime`, `duracaoEmAno`, `duracaoEmMeses`) VALUES ('Assalto', '2', '0');
INSERT INTO `jail_ts2022`.`tbcrimes` (`categoriaDeCrime`, `duracaoEmAno`, `duracaoEmMeses`) VALUES ('Assassinato', '1', '6');
INSERT INTO `jail_ts2022`.`tbcrimes` (`categoriaDeCrime`, `duracaoEmAno`, `duracaoEmMeses`) VALUES ('Caça furtiva', '3', '4');
INSERT INTO `jail_ts2022`.`tbcrimes` (`categoriaDeCrime`, `duracaoEmAno`, `duracaoEmMeses`) VALUES ('Assedio', '1', '5');
INSERT INTO `jail_ts2022`.`tbcrimes` (`categoriaDeCrime`, `duracaoEmAno`, `duracaoEmMeses`) VALUES ('Rapto', '5', '2');
INSERT INTO `jail_ts2022`.`tbcrimes` (`categoriaDeCrime`, `duracaoEmAno`, `duracaoEmMeses`) VALUES ('Porte de armas inlegal', '3', '5');
INSERT INTO `jail_ts2022`.`tbcrimes` (`categoriaDeCrime`, `duracaoEmAno`, `duracaoEmMeses`) VALUES ('Violação', '2', '3');
--  consulta
 alter table tbcrimes modify column categoriaDeCrime varchar(20) unique;
select * from tbcrimes ;

INSERT INTO `jail_ts2022`.`tbcategoria` (`categoria`) VALUES ('Chefe de Seguranca');
INSERT INTO `jail_ts2022`.`tbcategoria` (`categoria`) VALUES ('Director Geral');
INSERT INTO `jail_ts2022`.`tbcategoria` (`categoria`) VALUES ('Gestor');
INSERT INTO `jail_ts2022`.`tbcategoria` (`categoria`) VALUES ('Guarda presidiario');
INSERT INTO `jail_ts2022`.`tbcategoria` (`categoria`) VALUES ('Staff');
 select * from tbcategoria order by categoria;
 
 alter table tbcategoria modify column categoria varchar(20) unique;
 desc tbrecluso;
 
 alter table tbrecluso_has_tbcrimes add  `dataSaidaRegistro` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ();
select * from tbrecluso_has_tbcrimes;
-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

INSERT INTO `jail_ts2022`.`tbcelas` (`cela`) VALUES ('A');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('1');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('2');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('3');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('4');
-- cela B
INSERT INTO `jail_ts2022`.`tbcelas` (`cela`) VALUES ('B');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('1');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('2');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('3');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('4');
-- cela c
INSERT INTO `jail_ts2022`.`tbcelas` (`cela`) VALUES ('C');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('1');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('2');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('3');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('4');
-- cela D
INSERT INTO `jail_ts2022`.`tbcelas` (`cela`) VALUES ('D');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('1');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('2');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('3');
INSERT INTO `jail_ts2022`.`tbcama` (`nrcama`) VALUES ('4');
select * from  tbcelas_has_tbcama;
select * from tbcama where estadoDacama;
select * from tbcelas;


 select * from tbendereco;

drop table tbendereco ;


INSERT INTO `jail_ts2022`.`tbcelas` (`cela`, `capacidadeMax`) VALUES ('A', '5');
INSERT INTO `jail_ts2022`.`tbcelas` (`cela`, `capacidadeMax`) VALUES ('B', '5');
INSERT INTO `jail_ts2022`.`tbcelas` (`cela`, `capacidadeMax`) VALUES ('C', '5');
INSERT INTO `jail_ts2022`.`tbcelas` (`cela`, `capacidadeMax`) VALUES ('D', '5');

select * from tbrecluso ;