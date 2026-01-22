🛒 Online Shopping API Service

Bu proje, modern bir e-ticaret sisteminin temel ihtiyaçlarını karşılamak üzere geliştirilmiş, Spring Boot tabanlı bir RESTful API servisidir. Proje kapsamında kullanıcı yönetimi, satıcı ve dükkan ilişkileri, ürün yönetimi ve güvenlik katmanları entegre edilmiştir.


🚀 Kullanılan Teknolojiler

Java 25 & Spring Boot 3.5.x

Spring Data JPA (PostgreSQL veritabanı yönetimi için)

Spring Security & JWT (Güvenli kimlik doğrulama ve yetkilendirme)

Lombok (Boilerplate kodları azaltmak için)

Maven (Bağımlılık yönetimi)

SWAGER (Servis ve URL adresleri görüntüleme ve çalıştırma)

PostgreSQL (İlişkisel veritabanı)



🏗️ Veritabanı Mimarisi
Sistemde nesneler arasındaki ilişkiler (One-to-Many, Many-to-Many) titizlikle kurgulanmıştır. Temel tablolar şunlardır:

User / Seller: Kullanıcı ve satıcı rolleri.

Product: Ürün bilgilerinin tutulduğu ana tablo.

Shop: Satıcıların ürünlerini sergilediği dükkanlar.

ShopProduct: Ürünler ve dükkanlar arasındaki ilişkiyi yöneten ara tablo.



🔑 Öne Çıkan Özellikler

Güvenli Şifreleme: Satıcı şifreleri BCryptPasswordEncoder ile hash'lenerek güvenli bir şekilde saklanır.

Dinamik Hata Yönetimi: Projeye özel BaseException ve MessageType yapısı ile hata mesajları yönetilir.

DTO Tasarım Kalıbı: Entity nesnelerinin doğrudan dış dünyaya açılmasını önlemek için DTO (Data Transfer Object) kullanımı.

Validasyon Kontrolleri: Ürün ekleme işlemlerinde sellerId, shopId ve şifre doğrulaması gibi iş mantığı kontrolleri.



🛠️ Kurulum ve Çalıştırma

1. Projeyi klonlayın:

      Bash

      git clone https://github.com/Azad-star/OnlineShopingAPIService.git


2. src/main/resources/application.properties dosyasındaki PostgreSQL bağlantı bilgilerini

      kendinize göre güncelleyin.

3. Maven bağımlılıklarını yükleyin:

      Bash

      mvn clean install

4. Uygulamayı çalıştırın.
