# Usar a imagem oficial do Node.js para build
FROM node:18 AS build

WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

# Usar a imagem do Nginx para servir o frontend
FROM nginx:alpine

COPY --from=build /app/dist/hotel-checkin-frontend /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
