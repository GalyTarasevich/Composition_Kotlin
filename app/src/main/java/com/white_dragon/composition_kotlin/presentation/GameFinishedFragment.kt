package com.white_dragon.composition_kotlin.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.white_dragon.composition_kotlin.R
import com.white_dragon.composition_kotlin.databinding.FragmentGameFinishedBinding
import java.lang.RuntimeException

class GameFinishedFragment : Fragment() {

    private val args by navArgs<GameFinishedFragmentArgs>()

//    private lateinit var gameResult: GameResult // переделали навигацию

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")

//    override fun onCreate(savedInstanceState: Bundle?) { // переделали навигацию
//        super.onCreate(savedInstanceState)
//        parseArgs()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
//        bindViews()
        binding.gameResult = args.gameResult
    }

    private fun setupClickListeners() {
//        val callback = object : OnBackPressedCallback(true) { // переделали навигацию
//            override fun handleOnBackPressed() {
//                retryGame()
//            }
//        }
//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

//    private fun bindViews() {
//        binding.gameResult = args.gameResult
//        with(binding) { // переделали на dataBinding
//            emojiResult.setImageResource(getSmileResId())
//            tvRequiredAnswers.text = String.format(
//                getString(R.string.required_score),
//                args.gameResult.gameSettings.minCountOfRightAnswers
//            )
//            tvScoreAnswers.text = String.format(
//                getString(R.string.score_answers),
//                args.gameResult.countOfRightAnswers
//            )
//            tvRequiredPercentage.text = String.format(
//                getString(R.string.required_percentage),
//                args.gameResult.gameSettings.minPercentOfRightAnswers
//            )
//            tvScorePercentage.text = String.format(
//                getString(R.string.score_percentage),
//                getPercentOfRightAnswers()
//            )
//        }
//    }

//    private fun getSmileResId(): Int {
//        return if (args.gameResult.winner) {
//            R.drawable.ic_smile
//        } else {
//            R.drawable.ic_sad
//        }
//    }

//    private fun getPercentOfRightAnswers() = with(args.gameResult) { // переделали на dataBinding
//        if (countOfQuestions == 0) {
//            0
//        } else {
//            ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    private fun parseArgs() { // переделали навигацию
//        requireArguments().getParcelable<GameResult>(KEY_GAME_RESULT)?.let {
//            gameResult = it
//        }
//    }

    private fun retryGame() {
        findNavController().popBackStack()
//        requireActivity().supportFragmentManager.popBackStack( // переделали навигацию
//            GameFragment.NAME,
//            FragmentManager.POP_BACK_STACK_INCLUSIVE
//        )
    }

//    companion object { // переделали навигацию
//
//        const val KEY_GAME_RESULT = "game_result"
//
//        fun newInstance(gameResult: GameResult): GameFinishedFragment {
//            return GameFinishedFragment().apply {
//                arguments = Bundle().apply {
//                    putParcelable(KEY_GAME_RESULT, gameResult)
//                }
//            }
//        }
//    }
}