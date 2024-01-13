import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MessageModel
import com.example.myapplication.R

class ChatAdapter(private val context: Context, private val messageList: List<MessageModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // View types for sender and receiver messages
    private val VIEW_TYPE_SENDER = 1
    private val VIEW_TYPE_RECEIVER = 2

    // ViewHolder class for caching views
    inner class SenderViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val message: TextView = view.findViewById(R.id.message2)
        val date: TextView = view.findViewById(R.id.date)
        val timestamp: TextView = view.findViewById(R.id.timestamp)
    }

    inner class ReceiverViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val receiverName: TextView = view.findViewById(R.id.text_gchat_user_other)
        val messageReceiver: TextView = view.findViewById(R.id.text_gchat_message_other)
        val dateReceiver: TextView = view.findViewById(R.id.text_gchat_date_other)
        val timestampReceiver: TextView = view.findViewById(R.id.text_gchat_timestamp_other)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_SENDER -> {
                val senderView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.chat_item, parent, false)
                SenderViewHolder(senderView)
            }
            VIEW_TYPE_RECEIVER -> {
                val receiverView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.chat_other_user_item, parent, false)
                ReceiverViewHolder(receiverView)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messageList[position]

        when (holder.itemViewType) {
            VIEW_TYPE_SENDER -> {
                val senderHolder = holder as SenderViewHolder
                senderHolder.message.text = message.message
                senderHolder.date.text = message.sender.nickname
                //senderHolder.timestamp.text = mess
            }
            VIEW_TYPE_RECEIVER -> {
                val receiverHolder = holder as ReceiverViewHolder
                receiverHolder.receiverName.text = message.sender.nickname
                    receiverHolder.messageReceiver.text = message.message
                //receiverHolder.dateReceiver.text = /* set date, if available */
                    //receiverHolder.timestampReceiver.text = /* set timestamp, if available */
            }
        }
    }


    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun getItemViewType(position: Int): Int {
        val message = messageList[position]

        return if (message.isSender) {
            VIEW_TYPE_SENDER
        } else {
            VIEW_TYPE_RECEIVER
        }
    }
}
