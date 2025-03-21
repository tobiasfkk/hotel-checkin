# Usar a imagem oficial do Node.js
FROM node:18

# Criar diretório de trabalho no container
WORKDIR /app

# Copiar package.json e instalar dependências
COPY package.json package-lock.json ./
RUN npm install

# Copiar todo o código do frontend para dentro do container
COPY . .

# Expor a porta usada pelo Angular
EXPOSE 4200

# Comando para rodar o Angular dentro do container
CMD ["npm", "run", "start"]
