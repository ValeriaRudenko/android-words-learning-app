package com.example.lifruk.game_menu

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.lifruk.App
import com.example.lifruk.R
import com.example.lifruk.data.Topic
import com.example.lifruk.flashcard.FlashcardActivity
import com.example.lifruk.quiz.QuizGuessPictureActivity
import com.example.lifruk.quiz.QuizGuessWordActivity
import com.example.lifruk.view_model.TopicViewModel
import com.example.lifruk.view_model.TopicViewModelFactory
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class GameMenuActivity : AppCompatActivity(), TopicListAdapter.TopicItemListener {

    companion object {
        const val EXTRA_GAME = "selected_game"
    }

    // Topic database
    private lateinit var topics: MutableList<Topic>
    lateinit var newTopic: Topic

    private val topicViewModel: TopicViewModel by viewModels {
        TopicViewModelFactory((application as App).repository)
    }

    // Files
    private lateinit var topicAdapter: TopicListAdapter
    private lateinit var addTopicDialog: AddDialogFragment

    // View
    lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var button_addTopic: ExtendedFloatingActionButton
    private lateinit var tabLayout: TabLayout

    // var
    private lateinit var selected_game: String
    private var selected_type: String = "word"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_game_menu)

        getViewById()
        getIntentExtra()

        selectTab()

        topicData()
        topics = mutableListOf()
        newTopic = Topic(0, "")
        topicAdapter = TopicListAdapter(this)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@GameMenuActivity)
            adapter = topicAdapter
        }

        //swipeRefresh.setOnRefreshListener { viewModel.refreshTopics() }

        button_addTopic.setOnClickListener { showAddTopicDialog() }
    }

    private fun topicData() {
        topicViewModel.allTopics.observe(this, Observer { topics ->
            // Update the cached copy of the words in the adapter.
            topics?.let { topicAdapter.submitList(it) }
        })
    }

    private fun getViewById() {
        recyclerView = findViewById(R.id.recyclerView)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        coordinatorLayout = findViewById(R.id.coordinator_layout)
        button_addTopic = findViewById(R.id.button_addTopic)
        tabLayout = findViewById(R.id.tabLayout)
    }

    private fun getIntentExtra() {
        selected_game = intent.getStringExtra(EXTRA_GAME)!!
    }

    private fun selectTab() {
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> selected_type = "word"
                    1 -> selected_type = "audio"
                    2 -> selected_type = "picture"
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun showAddTopicDialog() {
        addTopicDialog = AddDialogFragment()
        addTopicDialog.listener = object :
            AddDialogFragment.ConfirmAddDialogListener {
            override fun onDialogPositiveClick(inputTopicName: String) {
                addTopic(inputTopicName)
                dismissTopicDialog()
            }
            override fun onDialogNegativeClick() {
                dismissTopicDialog()
            }
        }

        addTopicDialog.show(supportFragmentManager, "confirmAddDialog")
    }

    private fun dismissTopicDialog(){
        addTopicDialog.dismiss()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateTopics(newTopics: List<Topic>) {
        //Timber.d("List of topics $newTopics")
        topics.clear()
        topics.addAll(newTopics)
        topicAdapter.notifyDataSetChanged()
        swipeRefresh.isRefreshing = false
    }

    override fun onTopicSelected(topic: Topic) {
        val intent = configIntent()
        startActivity(intent)
    }

    private fun configIntent(): Intent? {
        when (selected_game) {
            "flashcard" -> intent = Intent(this, FlashcardActivity::class.java)
            "quiz" -> when (selected_type) {
                "word" -> intent = Intent(this, QuizGuessPictureActivity::class.java)
                "audio" -> intent = Intent(this, QuizGuessPictureActivity::class.java)
                "picture" -> intent = Intent(this, QuizGuessWordActivity::class.java)
            }
        }
        intent.putExtra("selected_type", selected_type)
        return intent
    }

    private fun addTopic(inputTopicName: String) {
        newTopic.name = inputTopicName
        topicViewModel.insertTopic(newTopic)
        //topicViewModel.deleteAllTopic()
    }

}
