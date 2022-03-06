# Задание Git

## Порядок выполнения работы
1. Форкаем `https://github.com/Kotlin-Polytech/KotlinAsFirst2020`, открываем в Идее через get from VCS, клонируем через `git clone`
2. Добавляем первый апстрим: `git remote add upstream-my https://github.com/IvanPetrushin/KotlinAsFirst2021`
3. Делаем fetch из только что добавленного апстрима: `git fetch upstream-my`
4. Создаем ветку backport и переходим в нее: `git checkout -b backport`
5. Переносим коммиты c решениями к последнему коммиту с хешом d535f3592006b8f2593c9f881d72c05164aadc13 в backport: `git cherry-pick d535f3592006b8f2593c9f881d72c05164aadc13...FETCH_HEAD`
6. Добавляем второй апстрим:  git remote add upstream-theirs `https://github.com/redhair-demon/KotlinAsFirst2021`
7. Аналогично делаем fetch из второго апстрима: `fetch upstream-theirs`
8. Перемещаемся в master: `git checkout master`
9. Сливаем ветки: `git merge backport upstream-theirs/master`
10. Разрешаем все вылетевшие конфликты (их смотрим через git status)
11. После разрешения всех конфликтов создаем файл remotes
12. Добавляем в remotes вывод git remote -v и коммитим в гит `git remote -v > remotes`, `git add remotes`, `git commit -m "Add remotes file`
13. Пушим на гитхаб
14. Создаем этот файлик и делаем Commit and Push на гитхаб