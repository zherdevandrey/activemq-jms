1. все анотации считываются бин пост процессорами
2. бинпост процессор имеет 2 метода: beforeProcessAfterInitialization/postProcessAfterInitialization
3. процесс инициализации состоит из вызова beforeProcessAfterInitialization/init/postProcessAfterInitialization
4. при создании прокси есть 2 подхлда. 1) на основе имплементации всех интерфейсов исходного класса 2) на основе наследования
5. создание прокси происходит на этапе postProcessAfterInitialization. чтобы не поломать другие бинпостпроцессоры
6. фазы конструктора constructor->before initial->post construct->after initial