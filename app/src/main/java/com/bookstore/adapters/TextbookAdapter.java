package com.bookstore.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bookstore.models.Textbook;
import com.bookstore.R;
import java.util.List;

public class TextbookAdapter extends RecyclerView.Adapter<TextbookAdapter.ViewHolder> {

    private Context context;
    private List<Textbook> textbookList;

    public TextbookAdapter(Context context, List<Textbook> textbookList) {
        this.context = context;
        this.textbookList = textbookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_textbook, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Textbook book = textbookList.get(position);

        holder.tvTitle.setText(book.getTitle());
        holder.tvAuthor.setText("By " + book.getAuthor());
        holder.tvModule.setText("Module: " + book.getModuleCode());
        holder.tvPrice.setText("R " + String.format("%.2f", book.getPrice()));
        holder.tvCopies.setText(book.getNumberOfCopies() + " cop" +
                (book.getNumberOfCopies() == 1 ? "y" : "ies") + " available");
        holder.tvSeller.setText("Seller: " + book.getSellerName());

        // Click listener - open detail screen
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context,
                    com.bookstore.activities.BookDetailActivity.class);
            intent.putExtra("title", book.getTitle());
            intent.putExtra("author", book.getAuthor());
            intent.putExtra("moduleCode", book.getModuleCode());
            intent.putExtra("edition", book.getEdition());
            intent.putExtra("copies", book.getNumberOfCopies());
            intent.putExtra("price", book.getPrice());
            intent.putExtra("sellerName", book.getSellerName());
            intent.putExtra("contactNumber", book.getContactNumber());
            intent.putExtra("bankName", book.getBankName());
            intent.putExtra("accountNumber", book.getAccountNumber());
            intent.putExtra("accountHolder", book.getAccountHolder());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return textbookList.size();
    }

    // Update list when searching
    public void updateList(List<Textbook> newList) {
        textbookList = newList;
        notifyDataSetChanged();
    }

    // ViewHolder pattern
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView tvTitle, tvAuthor, tvModule,
                tvPrice, tvCopies, tvSeller;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView   = itemView.findViewById(R.id.cardView);
            tvTitle    = itemView.findViewById(R.id.tvTitle);
            tvAuthor   = itemView.findViewById(R.id.tvAuthor);
            tvModule   = itemView.findViewById(R.id.tvModule);
            tvPrice    = itemView.findViewById(R.id.tvPrice);
            tvCopies   = itemView.findViewById(R.id.tvCopies);
            tvSeller   = itemView.findViewById(R.id.tvSeller);
        }
    }
}