<h1>食堂会員管理及び注文システム（ウェブ）</h1>

<h2>使用技術</h2>
<p><br>JSP（JSTL）、JAVA、Servlet、JavaScript（JQurry）、CSS、MySQL<br><br></p>
<h2>作業期間</h2>
<p><br>2020.04.28～2020.05.27<br><br></p>
<h2>概要</h2>
<p><br>MVCパターンモーデル2でデザインしたホームページです。ログイン、会員管理、注文管理、注文内訳確認、テーブル管理、メニュー管理などの機能がある小さなレストランを充実に具現してみました。データベースはMySQLを使用し、NAVERのDBServerを借りました。<br><br></p>
<h1>主な機能</h1>
<ol>
  <br>
    <li><strong>食堂規模管理</strong>
      <br>座席数の設定が可能です。削除しようとする座席にお客さんが座っている場合、削除できないようにするなど例外処理を集中的に構造を作りました。</li>
  <br>
    <li><strong>メニュー管理</strong>
      <br>マスターアカウントでページに接続するとデータベースにメニューを追加することが可能です。同じ名前のメニューが何回も登録できないようにしました。</li>
  <br>
    <li><strong>注文システム</strong>
      <br>注文するたびDBからメニューリストをもらうため、リアルタイムでメニュー変更点が反映できます。何よりも使うお客さんが便利だと思えるように作りました。</li>
  <br>
    <li><strong>決済機能</strong>
      <br>実際の計算モジュールはついていないので、実際にお金払うようなことはできないのですが、機能は具現できている状態です。</li>
  <br>
</ol>
<h2><a href="https://hgf107103.github.io/MyPortfolio/Project/webRestaurant.html" target="_blank">県本(LINK)</a></h2>
