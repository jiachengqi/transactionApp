FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
WORKDIR /app

COPY *.sln ./
COPY TransactionFrontend/*.csproj ./TransactionFrontend/
RUN dotnet restore

COPY TransactionFrontend/. ./TransactionFrontend/
WORKDIR /app/TransactionFrontend
RUN dotnet publish -c Release -o out

FROM nginx:alpine AS final
WORKDIR /usr/share/nginx/html

COPY --from=build /app/TransactionFrontend/out/wwwroot ./

COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
