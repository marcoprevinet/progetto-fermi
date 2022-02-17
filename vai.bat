call cd progetto-fermi-root
call mvn clean package -P test,snapshot quarkus:dev
call cd..
