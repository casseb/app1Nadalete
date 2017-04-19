<h2>Instalação</h2>
<hr>

Para executar, primeiro baixe o mysql installer pelo seguinte link: 
https://dev.mysql.com/downloads/installer/

Após Instalado, na interface do MySql Installer, selecione a opção de instalar o MySQL Server
<img src="http://image.prntscr.com/image/b1f0948384b342feab75ff6297dcc66d.png"/>

Lembre-se da senha do root utilizada!!!

Quando o mysql já estiver executando, adicione o mysql no path do windows de acordo com o seguinte tutorial:
https://dev.mysql.com/doc/mysql-windows-excerpt/5.7/en/mysql-installation-windows-path.html

Em seu prompt de comando execute os seguintes comandos:
<br>
<code>MYSQL -U ROOT -P
</code>
<br>
<code>
"Digite a senha definida no root"
</code>
<br>
<code>
CREATE DATABASE app1 CHARACTER SET utf8 COLLATE utf8_general_ci;
</code>
<br>
<code>
CREATE USER 'app1' IDENTIFIED BY 'app1';
</code>
<br>
<code>
GRANT ALL ON app1.* TO 'app1'@'%' IDENTIFIED BY 'app1';
</code>
<br>
<code>
GRANT ALL ON app1.* TO 'app1'@'localhost' IDENTIFIED BY 'app1';
</code>
<br>
<code>
FLUSH PRIVILEGES;
</code>
<br>

Entre no diretório do projeto que você clonou neste repositório e execute o seguinte comando:
<br>
<code>
mvn liquibase:update
</code>
<br>
<code>
mvn clean package spring-boot:run
</code>

Acesse o seguinte caminho, caso o retorno for igual ao do print abaixo, Parabéns!!!!!
http://localhost:8090/leitor/all

<img src="http://image.prntscr.com/image/86ceb60ad50e4c8a949622503d331e29.png"/>

Se der erro em alguma das etapas acima chama o Nadalete kkkkk
