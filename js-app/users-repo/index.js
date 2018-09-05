var githubDataService = (function() {
  var githubData = {};

  users = [
    {
      id: 101,
      repos: [
        {
          commits: ["first commit", "second commit"]
        }
      ]
    },
    {
      id: 102,
      repos: [
        {
          commits: ["first commit", "second commit", "3rd commit"]
        }
      ]
    }
  ];

  function getUser(id) {
    var user = users.filter(user => {
      return user.id === id;
    });
    return user;
  }

  githubData.getUsers = id => {
    return new Promise((resolve, reject) => {
      var user = getUser(id);
      if (user.length > 0) {
        resolve(user);
      } else {
        reject("Error in users: User " + id + " not found");
      }
    });
  };

  githubData.getRepo = id => {
    return new Promise((resolve, reject) => {
      var user = getUser(id);
      if (user.length > 0) {
        //console.log(user[0]);
        resolve(user[0]);
      } else {
        reject("Error in repos");
      }
    });
  };

  githubData.getCommits = id => {
    return new Promise((resolve, reject) => {
      var user = getUser(id);
      if (user.length > 0) {
        resolve(user[0].repos);
      } else {
        reject("Error in commits");
      }
    });
  };
  return githubData;
})();

githubDataService
  .getUsers(102)
  .then(user => {
    console.log("Printing user");
    var user = user.map(value => {
      //console.log(value.id);
      return value.id;
    });

    console.log(user[0]);
    return githubDataService.getRepo(user[0]);
  })
  .then(repo => {
    console.log("Printing repos");
    //console.log(repo);
    repo.repos.map(obj => {
      console.log(obj);
    });
    return githubDataService.getCommits(repo.id);
  })
  .then(
    commits => {
      console.log("Printing commits");
      //console.log(commits);
      commits.map(obj => {
        console.log(obj.commits);
      });
    },
    error => {
      console.log(error);
      return;
    }
  )
  .catch(error => {
    console.log(error);
  });
