# cqrsWithCleanArchitecture
Clean Architecture (Temiz Mimari)- CQRS (Command Query Responsibility Segregation - Komut ve Sorgu Sorumluluklarının Ayrışması) Nedir?

Clean Architecture Nedir?
Clean architecture, uygulamamızın bağımlıklarının tek yönlü ve içe doğru olmasını savunan bir yazılım mimarisidir.(Tasarım Desenidir!)
Bu mimaride yazılım belirli katmanlara ayrılmıştır bunlar Domain, Application, Infrastructure ve Presentation‘dır.

1.Domain: Bu katman bizim çekirdek katmanımızdır. Bu katman diğer hiçbir katmana bağımlı değildir. 
Bu katmanda business entitylerimiz olur bunlar genelde basit ve küçük sınıflar olur. 
Ayrıca Value Objects, Logic, Exceptions ve Enemurationlarımız da bu katmanda yer alır.

2.Application: Application katmanı sadece Domain katmanına bağımlıdır ve oradaki bileşenleri kullanarak business
logic’i oluşturur. Bu iki katman ile uygulamamızı oluştururuz. Bu katmanda verileri nasıl saklıyacağımızın,
client ile nasıl iletişime geçeceği gibi konuları soyut bir şekilde oluşturup diğer üst katmanlarda bunları gerekiyorsa
implemente edip kullanırız. O yüzden bu katmanda Interface, Model, Logic, Command/Queries, Validators/ Exceptions’ larımız
bulunabilir.

3.Infrastructure/ws: Bu katmanda application katmanında ki Interfaceleri implemente ederek veritabanı gibi operasyonların
implementasyonlarını yaparız. Api'ler olarak düşünebiliriz. Projemizin hiçbir katmanı bu katmana bağımlı değildir.

4.Presentation: Bu katman kullanıcının uygulama ile iletişime geçtiği katmandır. Bu katman da konsol, api ve ya mvc projesi 
olabilir. Bu katman en üst katmanlardan biridir bu yüzden hiç bir katman bu katmana bağımlı değildir.

------------------------------------------------------------------------------------------------------------------------------------------------------------------
CQRS NEDİR?

CQRS, ana odağı write (yazma) ve read (okuma) sorumluluklarının ayrıştırılmasına dayanan bir mimari tasarım modelidir.
Bu yaklaşımda metotlar 2 farklı modele ayrılmalıdır:

Commands: Objenin veya sistemin durumunu değiştirir/Olmayan veriyi oluşturan ya da var olan bir veri üzerinde güncelleme veya silme işlemi yapan isteklerdir.
Yani veri tabanında değişiklik yapacak metotlarımızı bu kısım (command) içine yazarız. (INSERT UPDATE DELETE) !!!


Queries: Sadece sonucu geriye döner herhangi bir objenin veya sistemin durumunu değiştirmez/Mevcut verileri sadece listelemek, okumak yahut sunmak için read işlemi yapan isteklerdir.
Yani veri tabanında değişiklik yapmayan metotları bu kısım(Queries) içine yazarız. Get metotları olarak söyleyebiliriz!!!
*SELECT

CQRS Ne Zaman Kullanılmalı ?

-Birbirinden ayrı sistemlerde olası bir servisin hata vermesi durumunda bu hatanın sistemin akışına olumsuz yönde etkisi olmuyorsa kullanılabilir.

-Kompleks iş kurallarının olabileceği veya iş kurallarının sık sık değiştiği yapılarda kullanılabilir.

-Yüksek veri trafiğinin olduğu sistemlerde kullanılabilir.


CQRS’i Ne Zaman Kullanmamalıyız ?

-İş kurallarının basit ve çok değişmediği sistemlerde,

-Basit CRUD (Create, Read, Update, Delete)  işlemlerinin yapıldığı sistemlerde CQRS kullanılması önerilmez.

CQRS’in Avantajları

-Read ve write operasyonlarının ayrılması performansı, ölçeklenebilirliği ve güvenliği artırmaya yardımcı olabilir.

-Read ve write işlemleriniz için farklı veritabanları kullanabilirsiniz.(Örneğin, yazma işlemleri için MySQL kullanırken okuma işlemleri için Couchbase kullanabilirsiniz).

-Read ve write işlemleri ayrıldığı için, herhangi yapılacak bir read işleminde write işlemini beklemek zorunda kalmayız.

-Her ekibin farklı Domain Logic’i üzerinde çalışabileceği bir yapı kurulmasına yardımcı olabilir.

CQRS’in Dezavantajları

-Kod karmaşıklığını arttırır.

-Event bazlı bir yapıya sahipseniz, uygulamanızın queue’da yer alan hataları ve tekrarlanan işlemleri yönetebilmesi 
gerekmektedir. Olası failover senaryolarını düşünmediğinizde veri kaybı veya daha büyük sorunlarla karşılaşabilirsiniz.



Kaynaklar:
1-https://docs.microsoft.com/en-us/azure/architecture/patterns/cqrs


