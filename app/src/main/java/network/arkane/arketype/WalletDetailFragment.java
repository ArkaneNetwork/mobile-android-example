package network.arkane.arketype;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import network.arkane.arketype.client.model.Wallet;

/**
 * A fragment representing a single Wallet detail screen.
 * This fragment is either contained in a {@link WalletListActivity}
 * in two-pane mode (on tablets) or a {@link WalletDetailActivity}
 * on handsets.
 */
public class WalletDetailFragment extends Fragment {

    /**
     * The dummy content this fragment is presenting.
     */
    private Wallet wallet;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WalletDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey("wallet")) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            wallet = (Wallet) getArguments().getSerializable("wallet");

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(wallet.getDescription());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wallet_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (wallet != null) {
            ((TextView) rootView.findViewById(R.id.wallet_detail)).setText(wallet.getAddress());
        }

        return rootView;
    }
}
