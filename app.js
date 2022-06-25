var greeting = 'hello world!';
console.log(greeting);

var YandexMusicApi = require('yandex-music-api');

var api = new YandexMusicApi();


app.get('/get_playlist', function (req, res) {
response = api.getPlaylist(req.query.user_id, req.query.playlist_id).then(function(playlist) {
      playlist[0].tracks.forEach(function(item) {
          console.log(item.track.title + ' - ' + item.track.artists[0].name);
      });
       console.log(playlist[0]);
      return playlist[0]
    });
   console.log(response);
   res.end(JSON.stringify(response));
})

var server = app.listen(8080, function () {
  var host = server.address().address
  var port = server.address().port
  console.log("Example app listening at http://%s:%s", host, port)
})
