# 🚀 API Regresyon Test Otomasyonu

Bu proje, Yazılım Test Mühendisliği dersi kapsamında geliştirilmiş bir REST API otomasyon projesidir. Proje içerisinde **FakeStore API** kullanılarak çeşitli GET ve POST istekleri simüle edilmiş; durum kodları (status code), yanıt süreleri (response time) ve JSON gövde (response body) doğrulamaları yapılmıştır.

## 🛠️ Kullanılan Teknolojiler

* **Programlama Dili:** Java
* **Test Framework'ü:** JUnit 5
* **API Test Kütüphanesi:** REST Assured
* **Assertion (Doğrulama):** Hamcrest
* **Proje Yönetimi:** Maven
* **IDE:** Eclipse

## 🧪 Test Senaryoları

Proje kapsamında aşağıdaki senaryolar koşulmuş ve başarılı (`6/6`) sonuç alınmıştır:

1.  **GET /products:** Tüm ürünlerin başarıyla listelenmesi ve yanıt süresi kontrolü (Status 200).
2.  **GET /products/{id}:** Belirli bir ürünün detaylarının (id, title, category vb.) doğrulanması.
3.  **GET /products/categories:** Tüm kategorilerin listelenmesi ve içeriğinin kontrolü.
4.  **GET /products/category/{kategori}:** Spesifik bir kategoriye ait ürünlerin listelenmesi.
5.  **POST /products:** JSON payload (request body) gönderilerek sisteme yeni ürün eklenmesi (Status 201).
6.  **POST /users:** İç içe geçmiş (nested) JSON verisi ile yeni kullanıcı oluşturma simülasyonu (Status 201).

## ⚙️ Projeyi Çalıştırma

Projeyi kendi bilgisayarınızda çalıştırmak için:
1. Repoyu bilgisayarınıza klonlayın.
2. Eclipse veya IntelliJ IDEA üzerinden `Maven Project` olarak içe aktarın (Import).
3. `pom.xml` üzerinden bağımlılıkların yüklenmesini bekleyin.
4. `src/test/java/com/testproject/ApiRegressionTest.java` dizinindeki test sınıfını `Run As > JUnit Test` seçeneği ile çalıştırın.

---
👨‍💻 **Geliştirici:** Ahmed Faruk Tüfek
