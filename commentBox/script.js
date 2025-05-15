$(document).ready(function () {
  // Sample comments returned from the server
  const comments = [
    {
      id: 1,
      author: "Kumar",
      message: "This is a sample comment",
      date: "9/22/2014",
    },
    {
      id: 2,
      author: "Kumar",
      message: "This is another sample comment",
      date: "9/23/2014",
    },
  ];

  // Function to render the comment list
  function renderComments() {
    $("#comment-list").empty();
    comments.forEach((comment) => {
      const commentItem = `
        <div class="comment-item">
          <div class="comment-author">${comment.author}</div>
          <div class="comment-date">${comment.date}</div>
          <div class="comment-message">${comment.message}</div>
        </div>
      `;
      $("#comment-list").append(commentItem);
    });
  }

  // Load initial comments
  renderComments();

  // Add comment functionality
  $("#add-comment").on("click", function () {
    const newComment = $("#comment-input").val().trim();
    if (newComment) {
      const newCommentData = {
        id: comments.length + 1,
        author: "Kumar", // Static author name
        message: newComment,
        date: new Date().toLocaleDateString(),
      };
      comments.push(newCommentData); // Add new comment to the array
      renderComments(); // Re-render comments
      $("#comment-input").val(""); // Clear input field
    } else {
      alert("Comment cannot be empty!");
    }
  });
});
